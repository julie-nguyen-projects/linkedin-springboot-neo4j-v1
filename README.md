# linkedin-springboot-neo4j-v1

#  Lancer Neo4J via Docker
Créer dans C:/VotreUtilisateur/ 2 dossiers : un data et un logs
Lancer la commande : docker run --publish=7474:7474 --publish=7687:7687 --volume=$HOME/neo4j/data:/data --volume=$HOME/neo4j/logs:/logs neo4j:3.0

L'interface est disponible sous http://localhost:7474/browser/
(premier mdp : neo4j, second mpd à configurer: pass)

# Lancer l'application java
L'interface et la première requête de récupérations des utilisateurs est disponible sous : 
http://localhost:8081/api/user
