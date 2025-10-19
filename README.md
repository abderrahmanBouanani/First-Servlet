# PremierServlet

A small Java Servlet web application (WAR) example using Jakarta Servlet API.

This repository contains a simple set of servlets and a JSP page demonstrating basic GET/POST handling and form processing.

Project highlights
- Java: source/target 15 (set in `pom.xml`)
- Build tool: Maven
- Packaging: WAR (see `pom.xml`)
- Servlet API: Jakarta Servlet 5.0 (provided by the servlet container, e.g. Tomcat 10+)

Repository layout (key files)
- `pom.xml` - Maven build configuration
- `src/main/webapp/index.jsp` - Simple homepage
- `src/main/webapp/WEB-INF/web.xml` - Minimal web.xml (project relies on annotations for servlet mappings)
- `src/main/java/com/example/*.java` - Servlet source files:
  - `HelloServlet.java`  -> mapped to `/hello`
  - `Ex1Servlet.java`   -> mapped to `/ex1`
  - `Ex2Servlet.java`   -> mapped to `/ex2` (GET shows a username form; POST responds with a greeting)
  - `Ex3Servelt.java`   -> mapped to `/ex3` (login form; in-memory users seeded in `init`)
  - `Ex4Servelet.java`  -> mapped to `/ex4` (simple calculator form)

Servlet endpoints (access relative to your app context, e.g. `http://localhost:8080/<context>/`)
- `/`             -> `index.jsp` (Hello World)
- `/hello`        -> `HelloServlet` (returns a small HTML greeting)
- `/ex1`          -> `Ex1Servlet` (displays hard-coded personal information)
- `/ex2`          -> `Ex2Servlet` (GET: form to enter `username`; POST: greeting or message when empty)
- `/ex3`          -> `Ex3Servelt` (GET: login form; POST: checks credentials against seeded users)
    - Seeded credentials (for testing):
      - `Alice` / `password123`
      - `Bob` / `securePass`
      - `Charlie` / `charlie2024`
- `/ex4`          -> `Ex4Servelet` (GET: calculator form; POST: performs add/subtract/multiply/divide)

Build and run
Requirements:
- JDK 15 (or compatible)
- Apache Maven
- A Servlet 5.0 compatible container (Tomcat 10+, Jetty 11+, etc.)

1) Build the WAR

For Windows CMD, run:

```cmd
mvn clean package
```

The WAR will be created at:

```
target/PremierServlet-1.0-SNAPSHOT.war
```

2) Deploy to Tomcat (example)
- Copy the WAR to your Tomcat `webapps` directory. Tomcat will unpack and deploy it on startup (or while running).

```cmd
copy target\PremierServlet-1.0-SNAPSHOT.war C:\path\to\tomcat\webapps\
```

- Access the app in your browser at:

```
http://localhost:8080/PremierServlet-1.0-SNAPSHOT/
```

If you want the app at the root context, rename the WAR to `ROOT.war` before copying.

Notes and small caveats
- The project uses annotation-based servlet mappings (`@WebServlet`) instead of `web.xml` entries. `web.xml` is present but minimal.
- The servlet classes `Ex3Servelt` and `Ex4Servelet` have non-standard spellings in their class names ("Servelt"/"Servelet") — this is just the filename/class name used in the project and does not affect runtime, but you may want to rename them for clarity if you edit the code.
- `Ex4Servelet` uses input attributes `type="number1"` and `type="number2"` in its HTML. Many browsers expect `type="number"` for numeric inputs; you may wish to change those to `type="number"` to improve UX and client-side validation.
- The servlet API dependency in `pom.xml` is declared with `<scope>provided</scope>` because the servlet container supplies the implementation at runtime.

Testing the endpoints
- After deploying, open the URLs above in your browser and try the forms for `/ex2`, `/ex3`, and `/ex4`.

Contributing
- Feel free to submit changes or refactorings. If you rename or move servlets, update their `@WebServlet` mappings or `web.xml` accordingly.

