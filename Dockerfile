# Utilise l'image officielle PostgreSQL comme image de base
FROM postgres

# Définit la variable d'environnement pour le nom de la base de données
ENV POSTGRESS_DB = postgres

# Définit la variable d'environnement pour l'user de la base de données
ENV POSTGRESS_USER = postgres

# Définit la variable d'environnement pour le mot de passe de l'user
ENV POSTGRESS_PASSWORD = postgres

# Indique que le conteneur écoute le port 5432
EXPOSE 5432