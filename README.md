
# Pendekin

Pendekin is a shortener link that generate 6 unique alphanumeric to consise your url.


## Features

- Shortener link
- Link access counter


## Tech Stack

Pendekin uses a number of open source projects to work in the way we want, such as:

- SpringBoot v3.x.x
- Java 17
- PostgreSql



## Installation

Clone or download the repo on your desire local folder

```bash
  git clone [URL]
```

Create database for Pendekin usage in your postgreSQL.

- Open terminal and and login with your Postgres superuser role (default using "postgres")

```bash
  psql --username [PostgreUsername] 
```

- Insert your Postgres Password

```bash
  Password for user postgres: [Fill the password]
```

- Create database for example named as "pendekindb" by write in your terminal

```bash
  CREATE DATABASE pendekindb
```

- No need to create the table because when you run the app, it will automatically create the table (DDL)

Fill the setting of your postgres configuration in the environment variable with key value :

```bash
DB_URL : [PostgreURL into pendekindb Database]
DB_USERNAME : [PostgreUsername]
DB_PASSWORD : [PostgrePassword]
```


## Usage/Examples
Run the project

```bash
mvn spring-boot:run
```

