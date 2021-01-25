package ru.hh.school.dao;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GenericDao {
  private final SessionFactory sessionFactory;

  public GenericDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  // GenericDao нужно для предоставления общих методов для работы с сущностями, например, можно описать
  // методы get или save, которые не часто будут различаться.

  public <T> T get(Class<T> clazz, Serializable id) {
    return getSession().get(clazz, id);
  }

  public void save(Object object) {
    if (object == null) {
      return;
    }
    getSession().save(object);
  }

  public void update(Object object) {
    if (object == null) {
      return;
    }
    getSession().update(object);
  }

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }


}
