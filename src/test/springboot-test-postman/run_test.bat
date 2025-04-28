@echo off
rem Obtener la fecha y hora en formato YYYYMMDD_HHMM
for /f "tokens=2 delims==" %%I in ('"wmic os get localdatetime /value"') do set datetime=%%I
set fecha=%datetime:~0,4%%datetime:~4,2%%datetime:~6,2%_%datetime:~8,2%%datetime:~10,2%

rem Ejecutar Newman con los archivos dentro del repositorio
newman run "src/test/springboot-test-postman/SpringBoot Tests.postman_collection.json" ^
-e "src/test/springboot-test-postman/localhost.postman_environment.json" ^
--reporters cli,htmlextra ^
--reporter-htmlextra-export "src/test/springboot-test-postman/reporte_%fecha%.html"