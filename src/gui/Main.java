package gui;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("src/Luxor.owl");
		
		String query_header = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
							+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
							+ "PREFIX Luxor: <http://www.semanticweb.org/omar/ontologies/2017/2/Luxor#>";
		
		String query = query_header
				+ "SELECT ?activity ?start ?end ?duration "
				+ "WHERE { ?activity Luxor:satisfies ?interest ; "
				+ "Luxor:available_at Luxor:Berlin ; "
				+ "Luxor:activity_start ?start ;"
				+ "Luxor:activity_end ?end ;"
				+ "Luxor:duration_in_hours ?duration . "
				+ "?user Luxor:interested_in ?interest "
				+ "FILTER(?user = Luxor:User5) }"
				+ "GROUP BY ?activity ?start ?end ?duration";
		
		Query q = QueryFactory.create(query);
		QueryExecution qexec = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec.execSelect();
		
		ResultSetFormatter.outputAsCSV(new FileOutputStream("output2.csv"), res);
		System.out.println("Exported to csv");
		
		Query q1 = QueryFactory.create(query);
		QueryExecution qexec1 = QueryExecutionFactory.create(q1, m);
		ResultSet res1 = qexec1.execSelect();
		
		ArrayList<Activity> activities = new ArrayList<Activity>();
		while(res1.hasNext()) {
			QuerySolution qs = res1.nextSolution();
			Activity a = new Activity(
					qs.getResource("activity").toString(),
					qs.getLiteral("start").getString(), 
					qs.getLiteral("end").getString(), 
					qs.getLiteral("duration").getFloat()
				);
			activities.add(a);
		}
		
		System.out.println("Activities");
		for(Activity a : activities) {
			System.out.println("\t" + a.toString());
		}
		
		
		int days = 2;
		Calendar day_calendar = Calendar.getInstance();
		Calendar activity_calendar = Calendar.getInstance();
		ArrayList< ArrayList<ScheduledActivity> > all_trip_scheduled_activites = new ArrayList< ArrayList<ScheduledActivity> >();
		for(int i = 0; i < days; i++) {
			ArrayList<ScheduledActivity> current_day_scheduled_activities = new ArrayList<ScheduledActivity>();
			Time current_time = new Time(7, 00, 00);
			Time day_end_time = new Time(23, 00, 00);
			
			while(current_time.before(day_end_time)) {
				Collections.shuffle(activities);
				boolean found_suitable_activity = false;
				for(int j = 0; j < activities.size(); j++) {
					if(activities.get(j).start_time.before(current_time) || activities.get(j).start_time.equals(current_time)) {	
						day_calendar.setTime(current_time);
						day_calendar.add(Calendar.HOUR_OF_DAY, (int) activities.get(j).duration);
						day_calendar.add(Calendar.MINUTE, (int) ((activities.get(j).duration % 1) * 60));
						Time activity_end_time = new Time(day_calendar.getTime().getTime());
						if (activity_end_time.before(day_end_time) || activity_end_time.equals(day_end_time)) {
							found_suitable_activity = true;
							ScheduledActivity sa = new ScheduledActivity(activities.get(j), current_time);
							current_day_scheduled_activities.add(sa);
							day_calendar.add(Calendar.HOUR_OF_DAY, 1);
							current_time = new Time(day_calendar.getTime().getTime());
							activities.remove(j);
							break;
						}
					}
				}
				
				if(!found_suitable_activity) {
					day_calendar.setTime(current_time);
					day_calendar.add(Calendar.HOUR_OF_DAY, 1);
					current_time = new Time(day_calendar.getTime().getTime());
				}
			}
			
			all_trip_scheduled_activites.add(current_day_scheduled_activities);
		}
		
		for(int i = 0; i < all_trip_scheduled_activites.size(); i++) {
			ArrayList<ScheduledActivity> current_day_scheduled_activities = all_trip_scheduled_activites.get(i);
			System.out.println("Day " + (i+1) + ":");
			for(ScheduledActivity sa : current_day_scheduled_activities){
				System.out.println("\t" + sa.toString());
			}
		}
	}
}

class Activity {
	String name;
	Time start_time, end_time;
	float duration;
	
	public Activity(String name, String start_time, String end_time, float duration) {
		this.name = name.split("#")[1];
		String[] raw_start_time = start_time.substring(11, 19).split(":");
		this.start_time =  new Time(Integer.parseInt(raw_start_time[0]), Integer.parseInt(raw_start_time[1]), Integer.parseInt(raw_start_time[2]));
		String[] raw_end_time = end_time.substring(11, 19).split(":");
		this.end_time = new Time(Integer.parseInt(raw_end_time[0]), Integer.parseInt(raw_end_time[1]), Integer.parseInt(raw_end_time[2]));
		this.duration = duration;
	}
	
	public String toString() {
		return this.name + ", " + this.start_time.toString() + " -> " + this.end_time.toString() + ", " + duration + " hours";
	}
}

class ScheduledActivity  {
	Activity activity;
	Time start_time;
	
	public ScheduledActivity(Activity activity, Time start_time) {
		this.activity = activity;
		this.start_time = start_time;
	}
	
	public String toString() {
		return start_time.toString() + " -> " + activity.name;
	}
}
