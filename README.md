# linkedin-springboot-neo4j-v1

#  Lancer Neo4J via Docker
Créer dans C:/VotreUtilisateur/ 2 dossiers : un data et un logs
Lancer la commande : 
```
docker run --publish=7474:7474 --publish=7687:7687 --volume=$HOME/neo4j/data:/data --volume=$HOME/neo4j/logs:/logs neo4j:3.0
```

L'interface est disponible sous http://localhost:7474/browser/
(premier mdp : neo4j, second mpd à configurer: pass)

# Insérer des données
Sur l'interface Neo4j: copier / coller les requêtes suivantes : 
```
CREATE (Lyon:City{name: 'Lyon'})
CREATE (Chambery:City{name: 'Chambery'})
CREATE (France:Country {name:'France'})
CREATE (Julie:User{name:'Julie', lastname:'Nguyen'})
CREATE (Toto:User{name:'Toto', lastname:'TotoName'})
CREATE (Titi:User{name:'Titi', lastname:'TitiName'})

CREATE (Julie)-[:LIVES_IN]->(Lyon)
CREATE (Toto)-[:LIVES_IN]->(Lyon)
CREATE (Titi)-[:LIVES_IN]->(Chambery)
CREATE (Chambery)-[:IS_IN]->(France)
CREATE (Lyon)-[:IS_IN]->(France)
```

Création d'une école Epitech à Lyon
```
MATCH (lyon {name: "Lyon"})
CREATE (EpitechLyon:School{name: 'EpitechLyon'})
CREATE (EpitechLyon)-[:IS_LOCATED_IN]->(lyon)
```

Lien entre l'école et l'utilisateur
```
MATCH (lyon {name: "Lyon"}), (julie {name: "Julie"}), (epitech{name: 'EpitechLyon'})
CREATE (julExp01:Experience {beginningDate:'2017-09'})
CREATE (julie)-[:HAS_EXPERIENCES]->(julExp01)
CREATE (julExp01)-[:STUDY]->(epitech)
```

// Création d'une entreprise à Lyon
```
MATCH (lyon {name: "Lyon"})
CREATE (EntrepriseUne:Company{name: 'EntrepriseUne'})
CREATE (EntrepriseUne)-[:IS_LOCATED_IN]->(lyon)
```

# Lancer l'application java
L'interface et la première requête de récupérations des utilisateurs est disponible sous : 
http://localhost:8081/users
Récupération des villes (autre tentative de récupération de données par point d'entrée différent):
Get un user par id
http://localhost:8081/users/id/{id}
Get tous les users par ville
http://localhost:8081/users/city/{cityName}



