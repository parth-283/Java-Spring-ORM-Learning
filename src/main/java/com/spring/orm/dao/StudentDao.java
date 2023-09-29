package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int insert(Student student) {
		// Insert student
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

//	get student by id
	public Student getStudent(int studentID) {
		// get by id
		Student student = this.hibernateTemplate.get(Student.class, studentID);
		return student;
	}

	// get all student
	public List<Student> getAllStudent() {
		// det all student
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}

	// delete student
	@Transactional
	public void deleteStudent(int studentID) {
		// delete student
		Student student = this.hibernateTemplate.get(Student.class, studentID);
		this.hibernateTemplate.delete(student);
	}

	// update student
	@Transactional
	public void updateStudent(Student student) {
		// update student
		this.hibernateTemplate.update(student);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
