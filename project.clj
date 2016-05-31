(defproject funny-face "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha3"]
                 [org.clojure/test.check "0.9.0"]
                 [ring "1.5.0-RC1"]
                 [compojure "1.5.0"]
                 [hiccup "1.0.5"]]
  :main funny-face.core
  :profiles {:dev
             {:main funny-face.core/-dev-main}})
