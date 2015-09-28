# Local Jenkins Infrastructure

This project configures Jenkins infrastructure locally out of the box

## Steps for running a Jenkins instance locally based on [docker](http://www.docker.com/) containers

- ```docker-compose up```

## File structure

    .
    ├── local                       # local Jenkins instance
    │   ├── Dockerfile              # Docker file
    │   ├── fs                      # Jenkins File System
    │   │   └── jobs
    │   │       └── seed            # Job generator
    │   │           └── config.xml  # Config.xml file
    │   └── plugins.txt             # Plugins file
    │
    └── docker-compose.yml          # Docker compose file

## Plugins

- Edit plugins.txt file (format: pluginId:Version)
- Further details about [plugins](https://updates.jenkins-ci.org/download/plugins/)

## Requirements

- [Docker](https://docs.docker.com/installation/) (Version 1.8.0 onwards)

## Further reading

- [Docker Registry](https://registry.hub.docker.com/_/jenkins/)
- [Docker Compose](https://docs.docker.com/compose/)
