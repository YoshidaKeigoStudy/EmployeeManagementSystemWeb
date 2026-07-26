package employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import employee.model.Employee;

@Repository
/** 社員データの保管・取得 **/
public interface EmployeeRepository extends JpaRepository<Employee, String> {

	// 全社員情報を取得する（退職者を除く）
	public List<Employee> findByRetiredFalse();

	// 部署名で社員一覧を取得する（退職者を含む）
	public List<Employee> findByDepartment(String department);

	// 部署名で社員一覧を取得する（退職者を除く）
	public List<Employee> findByDepartmentAndRetiredFalse(String department);

}
