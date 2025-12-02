CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT salary from(
        SELECT salary,DENSE_RANK() OVER (ORDER BY Salary DESC)AS ranking
        from Employee
      )as ranked_salary
      where ranking=N
      LIMIT 1

  );
END