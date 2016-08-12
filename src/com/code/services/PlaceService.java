package com.code.services;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.dal.orm.Place;
@SuppressWarnings("serial")
public class PlaceService implements Serializable {
	
	public static void insertPlace(Place place ) {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.save(place);

			session.getTransaction().commit();
			session.close();
			

	}
	
	public static void updatePlace(Place place ) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(place);

		session.getTransaction().commit();
		session.close();
		

	}

	public static List<Place> retrievePlaces (){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.getNamedQuery("Place_all");
		List<Place> places = (List<Place>) query.list();

		session.getTransaction().commit();
		session.close();
		return places;
	}
	
	public static List<Place> searchPlaces (String name){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.getNamedQuery("Place.name");
		query.setString(0,name);
		List<Place> places = (List<Place>) query.list();

		session.getTransaction().commit();
		session.close();
		return places;
	}

	public static List<Place> searchPlaceNPh (String name,String phone ){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.getNamedQuery("Place.name");
		query.setString(0,name);
		List<Place> places = (List<Place>) query.list();
		
		session.getTransaction().commit();
		session.close();
		if (phone==places.get(0).getPhoneNo())
		return places;
		else return null;
	}

	
	/*
	  public List<Place> searchByNameAndPhone(String name, String phone) {
	 
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.getNamedQuery("placeSearchByNameAndPhone");
		query.setString("name", name);
		query.setString("phoneNo", phone);

		List <Place>list = (List<Place>)query.list();
		
		

		session.getTransaction().commit();
		session.close();

		return list;
	}
*/
	public static List<Place> finalSearch(String name, String phone) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("placeSearchByNameAndPhone");
		if (name == null || name.trim().equals("")) {
			name = "-1";
		}
		if (phone == null || phone.trim().equals("")) {
			phone = "-1";
		}
		
		query.setString("name", name);
		query.setString("phoneNo", phone);
		
		@SuppressWarnings("unchecked")
		List<Place> place = (List<Place>) query.list();
		session.getTransaction().commit();
		session.close();
		return place;
	}
	public static void deletePlace(Place place){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.delete(place);
		
		session.getTransaction().commit();
		session.close();
	}
}