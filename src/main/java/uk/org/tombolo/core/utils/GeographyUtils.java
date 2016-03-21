package uk.org.tombolo.core.utils;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import uk.org.tombolo.core.Geography;
import uk.org.tombolo.core.GeographyType;

public class GeographyUtils {

	static Session session = HibernateUtil.getSessionFactory().openSession();

	public static Geography getGeographyByLabel(String label){
		Criteria criteria = session.createCriteria(Geography.class);
		return (Geography)criteria.add(Restrictions.eq("label", label)).uniqueResult();		
	}
	
	public static List<Geography> getGeographyByTypeAndLabelPattern(GeographyType geographyType, String labelPattern){
		Criteria criteria = session.createCriteria(Geography.class);
		criteria = criteria.add(Restrictions.eq("geographyType", geographyType));
		if (labelPattern != null)
			criteria = criteria.add(Restrictions.like("label", labelPattern));
		
		// FIXME: This should be paginated
		return (List<Geography>) criteria.list();		
	}
	
	public static Geography getTestGeography(){
		Criteria criteria = session.createCriteria(Geography.class);
		return (Geography)criteria
				.add(Restrictions.eq("label", "E01000001"))
				.uniqueResult();
	}
}
