# AGENTS

## Structure
- `java/` contains the Java study modules and build tooling.
- `scala/` contains the Scala study modules and build tooling.
- `remnote/` contains RemNote themes (CSS only for now).
- `data/modules.yml` is the canonical catalog consumed by external renderers such as the website.

## Commands
- Java build: `cd java && ./gradlew test`
- Scala build: `cd scala && sbt test`

## RemNote themes
- Each theme lives in `remnote/<theme-id>/` with `theme.css`, `manifest.json`, `logo.png`, and a single-image `README.md`.
- Package for upload: zip `theme.css`, `manifest.json`, and `logo.png` from the theme directory root.
- Themes with `"theme": ["dark"]` apply in RemNote dark mode only.

## Content Rules
- Keep one repository-level `README.md` and one repository-level `LICENSE.md` at the root.
- Keep module-specific `README.md` files inside each module directory when they describe that module.
