I: Set up libraries
    1. Set up index.html with the required libraries in the script tags;
    2. Set up firebase app;
    3. Add firebase configs inside your index.html file;
 ** Note: If you are using handlebars with sammy you must include also sammy-handlebars in your index.html

II: Config sammy (if sammy is used)

```js
// initialize the application
const app = Sammy('#main', function() {
    // Set handlebars as template engine if used
    this.use('Handlebars', 'hbs');
  
    // define your routes and handlers
    this.get('#/', homeViewHandler);
    ...
  });
  // start the application
  app.run('#/');

```
Look at the docs here : http://www.sammyjs.org/


firebase db config
```
{
  "rules": {
    ".read": "auth !== null",
    ".write": "auth !== null"
  }
}
```