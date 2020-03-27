# Movielens ETL application for transforming data from MySQL to MongoDB
A Java project to migrate the [movielens](https://grouplens.org/datasets/movielens/100k/) data from any RDBMS databse like MySQL to the MongoDB, a document oriented NoSQL database. This tool uses the best programming paradigms in the Java Programming language such as Dependency Injection(DI) using Spring and Object Relational Mapping(ORM) using Hibernate with JPA annotations. Spring-Hibernate has been used to read the data from MySQL database, and then converts this data into a suitable format as per my MongoDB document design. Spring – MongoDB driver has been used to insert the documents into the MongoDB.
### Prerequisites

Softwares Required:
* Java v1.8 or higher
* Maven v3.x
* MySQL v5.7.6 community edition
* MongoDB v4.0.2 community edition
* Your favourite Java IDE

### Installing

* Install MongoDB and MySQL if not installed already
* Execute the SQL script from the file movielens.sql. Please make sure that you do not have the databse named 'movielens' in your MySQL instance
* Clone the repository `git clone https://github.com/devinstincts/movielens-etl.git`
* Load the project into your IDE.
For Eclipse, File --> Import --> Import Existing Maven Projects into workspace
* Do `mvn install`
* Start the `mongod` deamon process
* Open the file `org.devinstincts.movielens_etl.driver.MovielensETLDriver` and run it as Java application

## Built With
* Java 8
* Maven 3.x
* MySQL 5.7.x
* MongoDB v4.0.2
* Eclipse v4.9.0

### RDBMS Schema

![Movielens RDBMS Schema](https://github.com/devinstincts/movielens-etl/blob/master/movielens-mysql-schema.jpg)

### Hibernate Entities and their realtionships

![Entity Models and their relationships](https://github.com/devinstincts/movielens-etl/blob/master/movielens-sql-entities.jpg)

### NoSQL Document JSON Schema

#### Movie Document Schema


```javascript
{
  "$schema": "http://json-schema.org/draft-04/schema#",
  "type": "object",
  "properties": {
    "id": {
      "type": "integer"
    },
    "title": {
      "type": "string"
    },
    "release_date": {
      "type": "string"
    },
    "video": {
      "type": "string"
    },
    "IMDBURL": {
      "type": "string"
    },
    "genres": {
      "type": "array",
      "items": {
        "type": "string"
      }
    },
    "rating": {
      "type": "array",
      "items": {
        "type": "object",
        "properties": {
          "user": {
            "type": "integer"
          },
          "rating": {
            "type": "integer"
          },
          "timestamp": {
            "type": "integer"
          }
        }
      }
    }
  }
}
```

#### User Document Schema


```javascript
{
  "$schema": "http://json-schema.org/draft-04/schema#",
  "type": "object",
  "properties": {
    "id": {
      "type": "integer"
    },
    "age": {
      "type": "integer"
    },
    "gender": {
      "type": "string"
    },
    "occupation": {
      "type": "string"
    },
    "zip_code": {
      "type": "string"
    }
  }
}
```

### Maven Dependencies


```
<properties>
	<spring.framework.version>4.2.4.RELEASE</spring.framework.version>
	<maven.compiler.source>1.8</maven.compiler.source>
	<maven.compiler.target>1.8</maven.compiler.target>
</properties>
<dependencies>
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-core</artifactId>
		<version>${spring.framework.version}</version>
	</dependency>

	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-orm</artifactId>
		<version>${spring.framework.version}</version>
	</dependency>

	<dependency>
		<groupId>org.hibernate</groupId>
		<artifactId>hibernate-entitymanager</artifactId>
		<version>5.0.6.Final</version>
	</dependency>


	<dependency>
		<groupId>org.hibernate</groupId>
		<artifactId>hibernate-core</artifactId>
		<version>5.0.6.Final</version>
	</dependency>

	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-context</artifactId>
		<version>${spring.framework.version}</version>
	</dependency>

	<dependency>
		<groupId>commons-dbcp</groupId>
		<artifactId>commons-dbcp</artifactId>
		<version>1.4</version>
	</dependency>

	<dependency>
		<groupId>javax.transaction</groupId>
		<artifactId>jta</artifactId>
		<version>1.1</version>
	</dependency>

	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<version>5.1.6</version>
	</dependency>

	<dependency>
		<groupId>org.springframework.data</groupId>
		<artifactId>spring-data-mongodb</artifactId>
		<version>1.10.0.RELEASE</version>
	</dependency>

</dependencies>
```

### Configuration

The properties file 'movielens-app-config.properties' needs to be modified as per your configuration.
```
# Hibernate dialect
hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
# RDBMS database URL
db.url=jdbc:mysql://localhost:3306/movielens
# RDBMS driver name
db.driver.classname=com.mysql.jdbc.Driver
# RDBMS Username
db.username=root
# RDBMS password
db.password=****
# Mongod host
mongo.host=localhost
# MongoDB port
mongo.port=27017
# MongoDB database name
mongo.db.name=movielens
```

## Authors

* **Nagendra Varma Nagaraju** - [Dev Instincts](https://devinstincts.com)

## License

This project is licensed under the MIT License


