java -cp "%USERPROFILE%\.m2\repository\com\h2database\h2\2.1.214\h2-2.1.214.jar" org.h2.tools.Server -tcp -ifNotExists -tcpPort 9092

REM java -cp "%USERPROFILE%\.m2\repository\com\h2database\h2\2.1.214\h2-2.1.214.jar" org.h2.tools.RunScript -url jdbc:h2:~/test -script test.sql