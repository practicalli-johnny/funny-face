# funny-face

A simple web service that returns a funny face, either as a photo hard-coded into the project or as an image generated from [quil](http://quil.info/).

> This project uses the current version of Clojure 1.9 as the plan was to also include clojure.spec.  However, during the dojo we ran out of time.

## Usage

You can run this project via the command line using Leiningen as follows

```
lein run 8000
```

8000 is the port number and you can choose any number not currently in use on your computer.

> TODO: a default port number should be added to the code so it will work when not run from the command line, for example from an editor such as Emacs/Spacemacs or LightTable

Once the project is running, you can view the web app via the following URL's

* [http://localhost:8000/] - displays a simple welcome message
* [http://localhost:8000/ring-face] - displays a hard-code image file from the project root
* [http://localhost:8000/quil-face] - displays a genrated frame from quil - use `Ctrl - r` to see the changing versions of the image

## License

Copyright © 2016 jr0cket

Distributed under the Creative Commons Attribution-ShareAlike 4.0 International (CC BY-SA 4.0)

