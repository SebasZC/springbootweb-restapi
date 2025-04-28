@echo off
for /f "tokens=2 delims==" %%I in ('"wmic os get localdatetime /value"') do set datetime=%%I
set fecha=%datetime:~0,4%%datetime:~4,2%%datetime:~6,2%_%datetime:~8,2%%datetime:~10,2%

:: Usar rutas relativas para apuntar a los archivos
newman run "%~dp0SpringBoot Tests.postman_collection.json" ^
-e "%~dp0localhost.postman_environment.json" ^
--reporters cli,htmlextra ^
--reporter-htmlextra-export "%~dp0reporte_%fecha%.html"