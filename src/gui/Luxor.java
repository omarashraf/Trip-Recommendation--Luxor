package gui;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

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

public class Luxor {
	
	String query_header = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
			+ "PREFIX Luxor: <http://www.semanticweb.org/omar/ontologies/2017/2/Luxor#>";
	
	public ArrayList<String> q1(String season) throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// all cities best to visit in a specific season
		String query_1 = query_header
				   + "SELECT * "
				   + "WHERE { ?city Luxor:best_time_to_visit Luxor:" + season + " }";
		
		Query q = QueryFactory.create(query_1);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<String> cities = new ArrayList<String>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			String city = qs.getResource("city").toString();
			cities.add(city);
		}
		return cities;
	}
	
	public ArrayList<String> q2(String category) throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// all cities best to visit in a specific season
		String query_2 = query_header
				   + "SELECT ?city "
				   + "WHERE { ?city Luxor:city_category Luxor:" + category + " }";
		
		Query q = QueryFactory.create(query_2);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<String> cities = new ArrayList<String>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			String city = qs.getResource("city").toString();
			cities.add(city);
		}
		return cities;
	}
	
	public ArrayList<String> q3(String city) throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// all historical attractions in a city
		String query_3 = query_header
				   + "SELECT * "
				   + "WHERE { ?activity rdf:type Luxor:History; "
				   + "Luxor:available_at Luxor:" + city + " . }";
		
		Query q = QueryFactory.create(query_3);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<String> his_activities = new ArrayList<String>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			String his_activity = qs.getResource("activity").toString();
			his_activities.add(his_activity);
		}
		return his_activities;
	}
	
	public ArrayList<HistActivities> q4() throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// all historical attractions with ranking sorted
		String query_4 = query_header
				   + "SELECT ?activity ?rating "
				   + "WHERE { ?activity rdf:type Luxor:History . "
				   + "?review Luxor:review_about ?activity ; "
				   + "Luxor:review_rating ?rating }"
				   + "ORDER BY DESC (?rating)";
		
		Query q = QueryFactory.create(query_4);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<HistActivities> his_activities = new ArrayList<HistActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			HistActivities his_activity = new HistActivities(
										qs.getResource("activity").toString(),
										0.0,
										qs.getLiteral("rating").getDouble());
			his_activities.add(his_activity);
		}
		return his_activities;
	}
	
	public ArrayList<HistActivities> q5(String ranking) throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// all historical attractions with specific ranking
		String query_5 = query_header
		   + "SELECT ?activity ?rating "
		   + "WHERE { ?activity rdf:type Luxor:History . "
		   + "?review Luxor:review_about ?activity ; "
		   + "Luxor:review_rating ?rating, ?rating FILTER(?rating=" + ranking + ") }";
		
		Query q = QueryFactory.create(query_5);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<HistActivities> his_activities = new ArrayList<HistActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			HistActivities his_activity = new HistActivities(
										qs.getResource("activity").toString(),
										0.0,
										qs.getLiteral("rating").getDouble());
			his_activities.add(his_activity);
		}
		return his_activities;
	}
	
	public ArrayList<HistActivities> q6() throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// all historical attractions that open in daylight
		String query_6 = query_header
				   + "SELECT ?activity ?start "
				   + "WHERE { ?activity rdf:type Luxor:History ; "
				   + "Luxor:activity_start ?start, ?start FILTER(?start < \"2017-01-01T19:00:00Z\"^^xsd:dateTime) }";
		
		Query q = QueryFactory.create(query_6);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<HistActivities> his_activities = new ArrayList<HistActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			HistActivities his_activity = new HistActivities(
										qs.getResource("activity").toString(),
										0.0,
										0.0);
			his_activities.add(his_activity);
		}
		return his_activities;
	}
	
	public ArrayList<HistActivities> q7() throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// all historical attractions that open at night
		String query_7 = query_header
				   + "SELECT ?activity ?end "
				   + "WHERE { ?activity rdf:type Luxor:History ; "
				   + "Luxor:activity_end ?end, ?end FILTER(?end > \"2017-01-01T19:00:00Z\"^^xsd:dateTime) }";
		
		Query q = QueryFactory.create(query_7);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<HistActivities> his_activities = new ArrayList<HistActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			HistActivities his_activity = new HistActivities(
										qs.getResource("activity").toString(),
										0.0,
										0.0);
			his_activities.add(his_activity);
		}
		return his_activities;
	}
	
	public ArrayList<HistActivities> q8() throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// all historical attractions together with prices
		String query_8 = query_header
				   + "SELECT ?activity ?price "
				   + "WHERE { ?activity rdf:type Luxor:History ; "
				   + "Luxor:price ?price }";
		
		Query q = QueryFactory.create(query_8);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<HistActivities> his_activities = new ArrayList<HistActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			HistActivities his_activity = new HistActivities(
										qs.getResource("activity").toString(),
										qs.getLiteral("price").getDouble(),
										0.0);
			his_activities.add(his_activity);
		}
		return his_activities;
	}
	
	public ArrayList<HistActivities> q9() throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// all historical attractions together with prices sorted
		String query_9 = query_header
				   + "SELECT ?activity ?price "
				   + "WHERE { ?activity rdf:type Luxor:History ; "
				   + "Luxor:price ?price }"
				   + "ORDER BY (?price)";
		
		Query q = QueryFactory.create(query_9);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<HistActivities> his_activities = new ArrayList<HistActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			HistActivities his_activity = new HistActivities(
										qs.getResource("activity").toString(),
										qs.getLiteral("price").getDouble(),
										0.0);
			his_activities.add(his_activity);
		}
		return his_activities;
	}
	
	public ArrayList<SportsActivities> q10(String city) throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// all sports activities in a city
		String query_10 = query_header
				   + "SELECT ?activity "
				   + "WHERE { ?activity rdf:type Luxor:Sports ; "
				   + "Luxor:available_at Luxor:" + city + " }";
		
		Query q = QueryFactory.create(query_10);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<SportsActivities> sports_activities = new ArrayList<SportsActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			SportsActivities sp_act = new SportsActivities(
										qs.getResource("activity").toString(),
										0.0);
			sports_activities.add(sp_act);
		}
		return sports_activities;
	}
	
	public ArrayList<SportsActivities> q11() throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// all sports activities together with prices
		String query_11 = query_header
				   + "SELECT ?activity ?price "
				   + "WHERE { ?activity rdf:type Luxor:Sports ; "
				   + "Luxor:price ?price }";
		
		Query q = QueryFactory.create(query_11);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<SportsActivities> sports_activities = new ArrayList<SportsActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			SportsActivities sp_act = new SportsActivities(
										qs.getResource("activity").toString(),
										qs.getLiteral("price").getDouble());
			sports_activities.add(sp_act);
		}
		return sports_activities;
	}
	
	public ArrayList<SportsActivities> q12() throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// all sports activities that include water
		String query_12 = query_header
				   + "SELECT ?activity "
				   + "WHERE { ?activity rdf:type Luxor:Sports ; "
				   + "Luxor:satisfies Luxor:WaterActivities }";
		
		Query q = QueryFactory.create(query_12);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<SportsActivities> sports_activities = new ArrayList<SportsActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			SportsActivities sp_act = new SportsActivities(
										qs.getResource("activity").toString(),
										0.0);
			sports_activities.add(sp_act);
		}
		return sports_activities;
	}
	
	public ArrayList<SportsActivities> q13(String price) throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// all sports activities that have price less than a specific value
		String query_13 = query_header
				   + "SELECT ?activity ?price "
				   + "WHERE { ?activity rdf:type Luxor:Sports ; "
				   + "Luxor:price ?price, ?price FILTER(?price < " + price + ") }";
		
		Query q = QueryFactory.create(query_13);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<SportsActivities> sports_activities = new ArrayList<SportsActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			SportsActivities sp_act = new SportsActivities(
										qs.getResource("activity").toString(),
										qs.getLiteral("price").getDouble());
			sports_activities.add(sp_act);
		}
		return sports_activities;
	}
	
	public ArrayList<EntActivities> q15() throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// all entertainment activities
		String query_15 = query_header
				   + "SELECT ?activity "
				   + "WHERE { ?activity rdf:type Luxor:Entertainment } ";
		
		Query q = QueryFactory.create(query_15);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<EntActivities> ent_activities = new ArrayList<EntActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			EntActivities sp_act = new EntActivities(qs.getResource("activity").toString(),
													 0.0,
													 0.0);
			ent_activities.add(sp_act);
		}
		return ent_activities;
	}
	
	public ArrayList<EntActivities> q17() throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// entertainment activities that open in day light
		String query_17 = query_header
				   + "SELECT ?activity ?start ?price "
				   + "WHERE { ?activity rdf:type Luxor:Entertainment ; "
				   + "Luxor:activity_start ?start, ?start FILTER(?start < \"2017-10-01T19:00:00Z\"^^xsd:dateTime) } ";
		
		Query q = QueryFactory.create(query_17);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<EntActivities> ent_activities = new ArrayList<EntActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			EntActivities sp_act = new EntActivities(qs.getResource("activity").toString(),
												     0.0,
												     0.0);
			ent_activities.add(sp_act);
		}
		return ent_activities;
	}
	
	public ArrayList<EntActivities> q18(String price) throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// entertainment activities that open in day light and have price less than a specific value
		String query_18 = query_header
				   + "SELECT ?activity ?start ?price "
				   + "WHERE { ?activity rdf:type Luxor:Entertainment ; "
				   + "Luxor:price ?price ; "
				   + "Luxor:activity_start ?start, ?start FILTER(?start < \"2017-10-01T19:00:00Z\"^^xsd:dateTime && ?price < " + price + ") } ";
		
		Query q = QueryFactory.create(query_18);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<EntActivities> ent_activities = new ArrayList<EntActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			EntActivities sp_act = new EntActivities(qs.getResource("activity").toString(),
													 qs.getLiteral("price").getDouble(),
													 0.0);
			ent_activities.add(sp_act);
		}
		return ent_activities;
	}

	public ArrayList<EntActivities> q19(String duration) throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// entertainment activities that open in day light and have specific duration time
		String query_19 = query_header
				   + "SELECT ?activity ?start ?duration "
				   + "WHERE { ?activity rdf:type Luxor:Entertainment ; "
				   + "Luxor:duration_in_hours ?duration ; "
				   + "Luxor:activity_start ?start, ?start FILTER(?start < \"2017-10-01T19:00:00Z\"^^xsd:dateTime && ?duration = " + duration + ") } ";
		
		Query q = QueryFactory.create(query_19);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<EntActivities> ent_activities = new ArrayList<EntActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			EntActivities sp_act = new EntActivities(qs.getResource("activity").toString(),
													 0.0,
													 qs.getLiteral("duration").getDouble());
			ent_activities.add(sp_act);
		}
		return ent_activities;
	}
	
	public ArrayList<FoodActivities> q20() throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// all restaurants together with their cuisines
		String query_20 = query_header
					+ "SELECT ?activity ?cuisine "
			        + "WHERE { ?activity rdf:type Luxor:Food ; "
			        + "Luxor:food_style ?cuisine } ";
		
		Query q = QueryFactory.create(query_20);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<FoodActivities> food_activities = new ArrayList<FoodActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			FoodActivities food_act = new FoodActivities(qs.getResource("activity").toString(),
													   qs.getResource("cuisine").toString(),
													   0.0,
													   0);
			food_activities.add(food_act);
		}
		return food_activities;
	}

	public ArrayList<FoodActivities> q21(String cuisine) throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// restaurants with specific cuisine
		String query_21 = query_header
				+ "SELECT ?activity "
		        + "WHERE { ?activity rdf:type Luxor:Food ; "
		        + "Luxor:food_style Luxor:" + cuisine + " } ";
		
		Query q = QueryFactory.create(query_21);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<FoodActivities> food_activities = new ArrayList<FoodActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			FoodActivities food_act = new FoodActivities(qs.getResource("activity").toString(),
													   null,
													   0.0,
													   0);
			food_activities.add(food_act);
		}
		return food_activities;
	}

	public ArrayList<FoodActivities> q22(String cuisine) throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// restaurants with specific cuisine and are cheap
		String query_22 = query_header
				+ "SELECT ?activity ?price "
		        + "WHERE { ?activity rdf:type Luxor:Food ; "
		        + "Luxor:food_style Luxor:" + cuisine + " ; "
		        + "Luxor:price ?price, ?price FILTER(?price <= 100.0)} ";
		
		Query q = QueryFactory.create(query_22);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<FoodActivities> food_activities = new ArrayList<FoodActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			FoodActivities food_act = new FoodActivities(qs.getResource("activity").toString(),
													   null,
													   qs.getLiteral("price").getDouble(),
													   0);
			food_activities.add(food_act);
		}
		return food_activities;
	}

	public ArrayList<FoodActivities> q23() throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// rate of all restaurants
		String query_23 = query_header
				+ "SELECT ?activity ?rating "
		        + "WHERE { ?activity rdf:type Luxor:Food . "
		        + "?review Luxor:review_about ?activity ; "
		        + "Luxor:review_rating ?rating } ";
		
		Query q = QueryFactory.create(query_23);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<FoodActivities> food_activities = new ArrayList<FoodActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			FoodActivities food_act = new FoodActivities(qs.getResource("activity").toString(),
													   null,
													   0.0,
													   qs.getLiteral("rating").getInt());
			food_activities.add(food_act);
		}
		return food_activities;
	}

	public ArrayList<FoodActivities> q24(String cuisine) throws FileNotFoundException {
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		// rate of all restaurants of specific cuisine
		String query_24 = query_header
				+ "SELECT ?activity ?rating ?cuisine "
		        + "WHERE { ?activity rdf:type Luxor:Food ;"
		        + "Luxor:food_style ?cuisine . "
		        + "?review Luxor:review_about ?activity ; "
		        + "Luxor:review_rating ?rating  "
		        + "FILTER(?cuisine = Luxor:" + cuisine + " ) } ";
		
		Query q = QueryFactory.create(query_24);
		QueryExecution qexec1 = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec1.execSelect();
		
		ArrayList<FoodActivities> food_activities = new ArrayList<FoodActivities>();
		while(res.hasNext()) {
			QuerySolution qs = res.nextSolution();
			FoodActivities food_act = new FoodActivities(qs.getResource("activity").toString(),
													   qs.getResource("cuisine").toString(),
													   0.0,
													   qs.getLiteral("rating").getInt());
			food_activities.add(food_act);
		}
		return food_activities;
	}

	
	public static void main(String[] args) throws FileNotFoundException {
		
		Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		m.read("Luxor.owl");
		
		String query_header = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
							+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
							+ "PREFIX Luxor: <http://www.semanticweb.org/omar/ontologies/2017/2/Luxor#>";

		// sports activities that match with my interests
		// random user
		String query_14 = query_header
				   + "SELECT ?activity "
				   + "WHERE { ?activity rdf:type Luxor:Sports ; "
				   + "Luxor:satisfies ?interest . "
				   + "?user Luxor:interested_in ?interest "
				   + "FILTER (?user = Luxor:User5) }"
				   + "GROUP BY ?activity";
		
		// entertainment activities that match with my interests
		// random user
		String query_16 = query_header
				   + "SELECT ?activity  "
				   + "WHERE { ?activity rdf:type Luxor:Entertainment ; "
				   + "Luxor:satisfies ?interest . "
				   + "?user Luxor:interested_in ?interest "
				   + "FILTER (?user = Luxor:User5) }"
				   + "GROUP BY ?activity";
		
		/*Query q = QueryFactory.create(query_14);
		QueryExecution qexec = QueryExecutionFactory.create(q, m);
		ResultSet res = qexec.execSelect();
		
		
		ResultSetFormatter.outputAsCSV(new FileOutputStream("output2.csv"), res);*/
		
	}
}
