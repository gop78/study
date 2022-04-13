# ORA-28001: the password has expired (비밀번호 만료)

- 오라클 11G r2 부터 기본 180일이 지나면 비밀번호가 만료되었음

-  기간이 만료된 비밀번호 변경

- 개인 로컬환경에서는 비밀번호 만료 되지 않도록 설정

1. DBA 계정으로 오라클 접속
    - C:\> sqlplus “/as sysdba”
2. 비밀번호 기간 만료된 계정 비밀번호 변경
    - ALTER USER user_id IDENTIFIED BY new_password;
3. 비밀번호 만료가 되지 않도록 설정
    - ALTER PROFILE DEFAULT LIMIT PASSWORD_LIFE_TIME UNLIMITED;
    

추가1) 로그인 시 비밀번호 10회 틀리면 잠금

- ALTER USER user_id ACCOUNT UNLOCK;