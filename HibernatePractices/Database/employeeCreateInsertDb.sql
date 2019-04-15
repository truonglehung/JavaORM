insert into Department (DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION)
values (10, 'ACCOUNTING', 'D10', 'NEW YORK');
  
insert into Department (DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION)
values (20, 'RESEARCH', 'D20', 'DALLAS');
  
insert into Department (DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION)
values (30, 'SALES', 'D30', 'CHICAGO');
  
insert into Department (DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION)
values (40, 'OPERATIONS', 'D40', 'BOSTON');
  
-------------------------------------------------------------------------------------------------
  
  
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7839, 'KING', 'E7839', Str_To_Date('17-11-1981', '%d-%m-%Y'), 'PRESIDENT', 5000, 10, null);
  
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7566, 'JONES', 'E7566', Str_To_Date('02-04-1981', '%d-%m-%Y'), 'MANAGER', 2975, 20, 7839);
  
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7902, 'FORD', 'E7902', Str_To_Date('03-12-1981', '%d-%m-%Y'), 'ANALYST', 3000, 20, 7566);
  
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7369, 'SMITH', 'E7369', Str_To_Date('17-12-1980', '%d-%m-%Y'), 'CLERK', 800, 20, 7902);
  
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7698, 'BLAKE', 'E7698', Str_To_Date('01-05-1981', '%d-%m-%Y'), 'MANAGER', 2850, 30, 7839);
  
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7499, 'ALLEN', 'E7499', Str_To_Date('20-02-1981', '%d-%m-%Y'), 'SALESMAN', 1600, 30, 7698);
  
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7521, 'WARD', 'E7521', Str_To_Date('22-02-1981', '%d-%m-%Y'), 'SALESMAN', 1250, 30, 7698);
  
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7654, 'MARTIN', 'E7654', Str_To_Date('28-09-1981', '%d-%m-%Y'), 'SALESMAN', 1250, 30, 7698);
  
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7782, 'CLARK', 'E7782', Str_To_Date('09-06-1981', '%d-%m-%Y'), 'MANAGER', 2450, 30, 7839);
  
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7788, 'SCOTT', 'E7788', Str_To_Date('19-04-1987', '%d-%m-%Y'), 'ANALYST', 3000, 20, 7566);
  
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7844, 'TURNER', 'E7844', Str_To_Date('08-09-1981', '%d-%m-%Y'), 'SALESMAN', 1500, 30, 7698);
  
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7876, 'ADAMS', 'E7876', Str_To_Date('23-05-1987', '%d-%m-%Y'), 'CLERK', 1100, 20, 7698);
  
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7900, 'ADAMS', 'E7900', Str_To_Date('03-12-1981', '%d-%m-%Y'), 'CLERK', 950, 30, 7698);
  
insert into Employee (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, JOB, SALARY, DEPT_ID, MNG_ID)
values (7934, 'MILLER', 'E7934', Str_To_Date('23-01-1982', '%d-%m-%Y'), 'CLERK', 1300, 10, 7698);
  
-------------------------------------------------------------------------------------------------
  
insert into Salary_Grade (GRADE, HIGH_SALARY, LOW_SALARY)
values (1, 9999, 3001);