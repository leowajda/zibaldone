# AGENTS

## Structure
- `java/` contains the Java study modules and build tooling.
- `scala/` contains the Scala study modules and build tooling.
- `data/modules.yml` is the canonical catalog consumed by external renderers such as the website.

## Commands
- Java build: `cd java && ./gradlew test`
- Scala build: `cd scala && sbt test`

## Content Rules
- Keep one repository-level `README.md` and one repository-level `LICENSE.md` at the root.
- Keep module-specific `README.md` files inside each module directory when they describe that module.
