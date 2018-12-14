Swagger is an open specification and a set of tools for building REST APIs. 

Swagger's open API specification allows to define REST API in platform-independent form.

Swagger Editor and Codegen are tools for authoring APIs and then generate platform-specific code and documentation for REST APIs.
Swagger supports practically all modern languages and frameworks. 

See also: [http://editor.swagger.io](http://editor.swagger.io)  
  

# swagger-editor

Swagger Editor lets you edit Swagger API specifications in YAML inside your browser and to preview documentations in real time. Valid Swagger JSON descriptions can then be generated and used with the full Swagger tooling (code generation, documentation, etc).

Running swagger-editor as Docker image 
    
    docker pull swaggerapi/swagger-editor
    docker run -d -p 80:8080 swaggerapi/swagger-editor
    
This will run Swagger Editor (in detached mode) on port 80 on your machine, so you can open it by navigating to `http://localhost` in your browser


# swagger-codegen

`swagger-codegen` contains a template-driven engine to generate documentation, API clients and server stubs in different languages by parsing your OpenAPI / Swagger definition. http://swagger.io

Install

    brew install swagger-codegen

Generate docs

Here is an example usage:

    swagger-codegen generate -i /Users/${USER}/src/R-Apollo/cadflows/spec/swagger.yml -l ruby -o /tmp/test/
