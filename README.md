# The Tic tac toe Project

-----------------------------------------------------------------------------------

## Without JRE

### Build instructions

- Build distribuction using maven tools:

```
  mvn -P without-jre clean package
  ```

- Use the followig archieves:
  - `target/tic-tac-toe-1.0-SNAPSHOT-windows.zip` for Windows
  - `target/tic-tac-toe-1.0-SNAPSHOT-unix.tar.gz`for MacOS and Linux

### Run instructions

- Download [OpenJDK11](https://jdk.java.net/11/)
- Unzip the downloaded OpenJDK archieve
- Configurate the `PATH` environment variable:
    - Add `%JDK_HOME%/bin` directory for Windows
    - Add `$JDK_HOME%/bin` directory for MacOS and Linux

- Re-login or restart computer

- Unzip the Tic-tac-toe distribution:
  - Unzip `tic-tac-toe-{project.version}-windows.zip` for Windows
  - Unzip `tic-tac-toe-{project.version}-unix.tar.gz` for MacOS and Linux

- Go to unzipped directory
- Run game by double-click on the start scripts:
  - `start.cmd` for Windows
  - `start.sh` for MacOS or Linux

---------------------------------------------------------------------------------------

## With JRE

### Build instructions

- Build distribuction using maven tools:
  ```
  mvn -P with-jre clean package
  ```

- Use the followig archieves:
  - `target/tic-tac-toe-1.0-SNAPSHOT-windows.zip` for Windows
  - `target/tic-tac-toe-1.0-SNAPSHOT-linux.tar.gz` for Linux
  - `target/tic-tac-toe-1.0-SNAPSHOT-macos.tar.gz`for MacOS

### Run instructions

- Unzip the Tic-tac-toe distribution:
  - Unzip `tic-tac-toe-{project.version}-windows.zip` for Windows
  - Unzip `tic-tac-toe-{project.version}-linux.tar.gz` for Linux
  - Unzip `tic-tac-toe-{project.version}-macos.tar.gz` for MacOS


- Go to unzipped directory
- Run game by double-click on the start scripts:
  - `start.cmd` for Windows
  - `start.sh` for MacOS or Linux

-----------------------------------------------------------------------------------

## Readme tutorial

- https://guides.github.com/features/mastering-markdown/
- https://help.github.com/categories/writing-on-github/