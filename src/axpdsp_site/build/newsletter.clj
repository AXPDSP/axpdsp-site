(ns axpdsp-site.build.newsletter
  (:require [clojure.java.io :as io]
            [markdown.core :as md]))


(defn directory? [^java.io.File f]
  (.isDirectory f))

(defn files [d]
  (remove directory? (file-seq (io/file d))))

(defn parse-markdown [^java.io.File f]
  (let [{:keys [html metadata]} (md/md-to-html-string-with-meta (slurp f))]
    (into {:html html} metadata)))

(defn -main [& _]
  (println "Building newsletter...")
  (spit (io/file "resources/newsletter.edn")
        (->> (files "newsletter")
             (map parse-markdown)
             (sort-by (juxt :important :date) (comp - compare))
             vec
             prn-str))
  (println "Newsletter built."))
