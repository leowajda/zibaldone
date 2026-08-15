# AGENTS

## Structure
- `java/` contains the Java study modules and build tooling.
- `scala/` contains the Scala study modules and build tooling.
- `remnote/` contains RemNote themes (CSS only). It is not a website catalog language.
- `data/modules.yml` is the website catalog (Java and Scala only).

## Commands
- Java build: `cd java && ./gradlew test`
- Scala build: `cd scala && sbt test`

## RemNote themes
- Each theme lives in `remnote/<theme-id>/` with `theme.css`, `manifest.json`, `logo.png`, and a single-image `README.md`.
- Marketplace README images must be absolute `https://raw.githubusercontent.com/...` URLs. Relative `logo.png` does not render in RemNote.
- Package for upload: zip `theme.css`, `manifest.json`, `logo.png`, and `README.md` from the theme directory root.
- `"theme": ["light", "dark"]` is the dual-mode contract. `"theme": ["dark"]` is dark-only.
- Active theme: `remnote/cosmic-dark` (store id `cosmic-dark`).

## Content Rules
- Keep one repository-level `README.md` and one repository-level `LICENSE.md` at the root.
- Keep module-specific `README.md` files inside each module directory when they describe that module.
