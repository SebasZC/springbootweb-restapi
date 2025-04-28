@echo off
for /f "tokens=2 delims==" %%I in ('"wmic os get localdatetime /value"') do set datetime=%%I
set fecha=%datetime:~0,4%%datetime:~4,2%%datetime:~6,2%_%datetime:~8,2%%datetime:~10,2%

newman run "C:\Users\zapat\Documents\Cursos\GitHub_Actions\test_colection\SpringBoot Tests.postman_collection.json" ^
-e "C:\Users\zapat\Documents\Cursos\GitHub_Actions\test_colection\localhost.postman_environment.json" ^
--reporters cli,htmlextra ^
--reporter-htmlextra-export "C:\Users\zapat\Documents\Cursos\GitHub_Actions\test_colection\reporte_%fecha%.html"