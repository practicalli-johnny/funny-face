(defproject funny-face "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Creative Commons Attribution-ShareAlike 4.0 International (CC BY-SA 4.0)"
            :url "https://creativecommons.org/licenses/by-sa/4.0/"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha3"]
                 [org.clojure/test.check "0.9.0"]
                 [ring "1.5.0-RC1"]
                 [compojure "1.5.0"]
                 [hiccup "1.0.5"]
                 [quil "2.2.1"]]
  :main funny-face.core
  :profiles {:dev
             {:main funny-face.core/-dev-main}})
