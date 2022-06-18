package ru.isachenkoff.calculator.data;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.isachenkoff.calculator.operations.CalculationResult;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CalculationResultDAO extends DAO<CalculationResult> {
    
    protected Class<CalculationResult> getLoadingClass() {
        return CalculationResult.class;
    }
    
    public List<CalculationResult> selectLast(int count) {
        Session session = openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CalculationResult> query = criteriaBuilder.createQuery(CalculationResult.class);
        Root<CalculationResult> from = query.from(CalculationResult.class);
        query.select(from).orderBy(criteriaBuilder.desc(from.get("id")));
        List<CalculationResult> resultList = session.createQuery(query).setMaxResults(count).getResultList();
        session.close();
        return resultList;
    }
    
    public void deleteAll() {
        List<CalculationResult> results = selectAll();
        Session session = openSession();
        Transaction tx1 = session.beginTransaction();
        for (CalculationResult obj : results) {
            session.delete(obj);
        }
        tx1.commit();
        session.close();
    }
    
}
