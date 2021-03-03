## Overview
Time management Telegram Bot, helping with work\brake periods and task managment.

## Features
* Bot tracks your time, by telling when to rest, and when to work!
* Bot tracks your tasks and time spend on each one!


## Technologies
* Spring Boot
* Flyway
* PostgreSQL

## Release Notes
Can be found in [RELEASE_NOTES](RELEASE_NOTES.md).

## Authors
* Egor Nazarov - [RevuelArvida](https://github.com/RevuelArvida)

## Contributing
Please, follow [Contributing](CONTRIBUTING.md) page.

## Code of Conduct
Please, follow [Code of Conduct](CODE_OF_CONDUCT.md) page.

## License
This project is Apache License 2.0 - see the [LICENSE](LICENSE) file for details

## Deployment
Deployment process as easy as possible:
Required software:
- terminal for running bash scripts
- docker
- docker-compose

to deploy application, switch to needed branch and run bash script:

$ bash start.sh ${bot_username} ${bot_token}