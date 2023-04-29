package com.tcl.tclempservice;

import java.util.ArrayList;
import java.util.List;

import com.tcl.tclempservice.Dto.EmployeeFilterSearch;
import com.tcl.tclempservice.Dto.FilterSearch;
import com.tcl.tclempservice.Dto.RequestSearchDto;
import com.tcl.tclempservice.entities.Employee;
import com.tcl.tclempservice.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.Pattern;

@Service
public class EmpFilterSearchService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getSpecification(String column, String value) {

		Specification<Employee> spec = new Specification<Employee>() {

			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

				return criteriaBuilder.equal(root.get(column), value);
			}

		};
		return employeeRepository.findAll(spec);

	}

	public List<FilterSearch> getSpecification(List<FilterSearch> dtoList) {

		List<Predicate> predicateList = new ArrayList<>();

		Specification spec = new Specification<FilterSearch>() {

			@Override
			public Predicate toPredicate(Root<FilterSearch> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {

				for (FilterSearch dto : dtoList) {

					predicateList.add(criteriaBuilder.equal(root.get(dto.getColumn()), dto.getValue()));

				}

				return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
			}

		};

		return employeeRepository.findAll(spec);
	}

//	public List<FilterSearch> getSpecs(EmployeeFilterSearch employeeFilterSearch) {
//
//		List<Predicate> predicateList = new ArrayList<>();
//
//		Specification spec = new Specification<FilterSearch>() {
//
//			@Override
//			public Predicate toPredicate(Root<FilterSearch> root, CriteriaQuery<?> query,
//					CriteriaBuilder criteriaBuilder) {
//
//				for (FilterSearch dto : employeeFilterSearch.getEmpFilterSearchList()) {
//
//					predicateList.add(criteriaBuilder.equal(root.get(dto.getColumn()), dto.getValue()));
//
//				}
//				if (employeeFilterSearch.getGlobalOperators().equals("AND")) {
//
//					return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
//				} else {
//
//					return criteriaBuilder.or(predicateList.toArray(new Predicate[0]));
//
//				}
//			}
//
//		};
//
//		return employeeRepository.findAll(spec);
//	}

	public List<EmployeeFilterSearch> getSpecificationsByOperaors(EmployeeFilterSearch employeeFilterSearch) {

		List<Predicate> predicateList = new ArrayList<>();

		Specification spec = new Specification<EmployeeFilterSearch>() {

			@Override
			public Predicate toPredicate(Root<EmployeeFilterSearch> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {

				for (RequestSearchDto dto : employeeFilterSearch.getEmpFilterSearchList()) {

					switch (dto.getLocalOperators()) {

						case "LIKE":

							Predicate like = criteriaBuilder.like(root.get(dto.getColumn()),
									"%" + dto.getValue() + "%");

							predicateList.add(like);
							break;

						case "EQUAL":

							predicateList.add(criteriaBuilder.equal(root.get(dto.getColumn()), dto.getValue()));

							break;

						
						case "IN": 

							predicateList.add(criteriaBuilder.in(null));

							break;
						

						default:
							throw new IllegalArgumentException(
									"Unexpected value: " + dto.getLocalOperators());
					}

				}
				if (employeeFilterSearch.getGlobalOperators().equals("AND")) {

					return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
				} else {

					return criteriaBuilder.or(predicateList.toArray(new Predicate[0]));

				}
			}

		};

		return employeeRepository.findAll(spec);
	}

}
