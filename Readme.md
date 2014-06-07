# Using the Austin REPL to connect to your app

This is an example of getting an
[Austin](https://github.com/cemerick/austin) ClojureScript REPL connected to
your live [OM](https://github.com/swannodette/om) app.

## Usage

* Compile ClojureScript: `lein cljsbuild auto`
* Run the REPL: `lein repl`
* From inside the REPL, run the server: `(run!)`
* From inside the REPL, enter the ClojureScript REPL: `(cljs!)`
* To quit the ClojureScript REPL, type `:cljs/quit`
* Reap the benefits of your hard word: `(js/alert "Hee haw!")`
