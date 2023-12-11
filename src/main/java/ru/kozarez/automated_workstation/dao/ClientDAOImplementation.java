package ru.kozarez.automated_workstation.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.kozarez.automated_workstation.entities.ClientEntity;
import ru.kozarez.automated_workstation.models.ClientFilterForm;

import java.util.List;

@Repository
public class ClientDAOImplementation extends GenericDAOImplementation<ClientEntity, Long>{
    @Override
    public ClientEntity getById(Long id) {
        return getSession().get(ClientEntity.class, id);
    }

    @Override
    public List<ClientEntity> getAll() {
        return getSession().createQuery("from ClientEntity").list();
    }

    public List<ClientEntity> getByPassport(String passportSerial, String passportNumber) {
        Query query = getSession().createQuery("from ClientEntity where passportSerial = :passportSerial and passportNumber = :passportNumber");
        query.setParameter("passportSerial", passportSerial);
        query.setParameter("passportNumber", passportNumber);
        return query.list();
    }

    //Знаю, что это выглядит ужасно, но ничего лучше в моменте не придумал
    public List<ClientEntity> getByFilter(ClientFilterForm form){
        String jpql = "from ClientEntity";
        boolean isFirst = true;

        if (form.getSecondName() != null && !form.getSecondName().isEmpty()) {
            jpql += isFirst ? " where" : " and";
            jpql += " secondName = :secondName";
            isFirst = false;
        }

        if (form.getFirstName() != null && !form.getFirstName().isEmpty()) {
            jpql += isFirst ? " where" : " and";
            jpql += " firstName = :firstName";
            isFirst = false;
        }

        if (form.getPatronymic() != null && !form.getPatronymic().isEmpty()) {
            jpql += isFirst ? " where" : " and";
            jpql += " patronymic = :patronymic";
            isFirst = false;
        }

        if (form.getPassportSerial() != null && !form.getPassportSerial().isEmpty()) {
            jpql += isFirst ? " where" : " and";
            jpql += " passportSerial = :passportSerial";
            isFirst = false;
        }

        if (form.getPassportNumber() != null && !form.getPassportNumber().isEmpty()) {
            jpql += isFirst ? " where" : " and";
            jpql += " passportNumber = :passportNumber";
            isFirst = false;
        }

        if (form.getPhoneNumber() != null && !form.getPhoneNumber().isEmpty()) {
            jpql += isFirst ? " where" : " and";
            jpql += " phoneNumber = :phoneNumber";
            isFirst = false;
        }

        Query query = getSession().createQuery(jpql, ClientEntity.class);

        if (form.getSecondName() != null && !form.getSecondName().isEmpty()) {
            query.setParameter("secondName", form.getSecondName());
        }

        if (form.getFirstName() != null && !form.getFirstName().isEmpty()) {
            query.setParameter("firstName", form.getFirstName());
        }

        if (form.getPatronymic() != null && !form.getPatronymic().isEmpty()) {
            query.setParameter("patronymic", form.getPatronymic());
        }

        if (form.getPassportSerial() != null && !form.getPassportSerial().isEmpty()) {
            query.setParameter("passportSerial", form.getPassportSerial());
        }

        if (form.getPassportNumber() != null && !form.getPassportNumber().isEmpty()) {
            query.setParameter("passportNumber", form.getPassportNumber());
        }

        if (form.getPhoneNumber() != null && !form.getPhoneNumber().isEmpty()) {
            query.setParameter("phoneNumber", form.getPhoneNumber());
        }

        return query.list();
    }
}
