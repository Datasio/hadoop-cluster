{:dev
 {:dependencies
  [;;[com.palletops/pallet-vmfest "0.4.0-alpha.1"]
   [com.palletops/pallet "0.8.0-RC.9" :classifier "tests"]
   [com.palletops/pallet-lein "0.6.0-beta.9"]
   [com.palletops/hadoop-book-example "0.1.1"]
   [ch.qos.logback/logback-classic "1.0.9"]
 :release
 {:plugins [[lein-set-version "0.2.1"]]
  :set-version
  {:updates [{:path "README.md"
              :no-snapshot true
              :search-regex
              #"hadoop-cluster \"\d+\.\d+\.\d+\""}]}}

 :dist
 {:aot [#"palletops\..*" #"clojure\..*"]
  :jar-exclusions [#"logback-test.xml"]
  :uberjar-exclusions [#"logback-test.xml"]
  :aot-include [#"palletops\..*.*"
                #"pallet.crate.collectd.*"
                #"pallet.crate.graphite.*"
                #"pallet.node.Node.*"
                #"pallet.node.*"
                #"pallet.compute.*"
                #"pallet.algo.fsmop.Control.*"
                #"pallet.argument.DelayedArgument.*"
                #"pallet.argument.DelayedFunction.*"
                #"clojure.tools.logging.impl.Logger.*"
                #"clojure.tools.logging.impl.LoggerFactory.*"
                #"clojure.core.logic.IWalkTerm.*"
                #"clojure.core.logic.IBind.*"
                #"clojure.core.logic.ITake.*"
                #"clojure.core.logic.IReifiableConstraint.*"
                #"clojure.core.logic.IConstraintOp.*"
                #"clojure.core.logic.IConstraintWatchedStores.*"
                #"clojure.core.logic.IReifiableConstraint.*"
                #"clojure.core.logic.IRelevant.*"
                #"clojure.core.logic.IRunnable.*"
                #"clojure.core.logic.IWithConstraintId.*"
                #"clojure.core.logic.PMap.*"
                #"clojure.core.logic.ISubstitutions.*"
                #"clojure.core.logic.IUnifyTerms.*"
                #"clojure.core.logic.IUnifyWithLVar.*"
                #"clojure.core.logic.IUnifyWithMap.*"
                #"clojure.core.logic.IUnifyWithPMap.*"
                #"clojure.core.logic.IUninitialized.*"
                ]
  :clean-non-project-classes false
  :omit-source true
  :proguard {:target :jar
             :print-configuration "target/proguard/configuration.txt"
             :print-mapping "target/proguard/mapping.txt"
             :print-seeds "target/proguard/seeds.txt"
             :keep-interface [palletops.crate.hadoop.config.FinalProperty
                              pallet.compute.NodeTagReader
                              pallet.compute.NodeTagWriter
                              pallet.compute.ComputeService
                              pallet.node.Node
                              pallet.node.NodeHardware
                              pallet.node.NodeImage
                              pallet.node.NodePackager
                              pallet.node_value.NodeValueAccessor
                              pallet.algo.fsmop.Control
                              pallet.argument.DelayedArgument
                              pallet.argument.DelayedFunction
                              clojure.tools.logging.impl.Logger
                              clojure.tools.logging.impl.LoggerFactory
                              clojure.core.logic.IWalkTerm
                              clojure.core.logic.IBind
                              clojure.core.logic.ITake
                              clojure.core.logic.IReifiableConstraint
                              clojure.core.logic.IConstraintOp
                              clojure.core.logic.IConstraintWatchedStores
                              clojure.core.logic.IReifiableConstraint
                              clojure.core.logic.IRelevant
                              clojure.core.logic.IRunnable
                              clojure.core.logic.IWithConstraintId
                              clojure.core.logic.PMap
                              clojure.core.logic.ISubstitutions
                              clojure.core.logic.IUnifyTerms
                              clojure.core.logic.IUnifyWithLVar
                              clojure.core.logic.IUnifyWithMap
                              clojure.core.logic.IUnifyWithPMap
                              clojure.core.logic.IUninitialized
                              ]
             ;; :keep-ns ["pallet.node$NodeHardware"]
             :keep-fns [palletops.cluster.hadoop.cli.destroy/destroy
                        palletops.cluster.hadoop.cli.start/start
                        palletops.cluster.hadoop.cli.job/job
                        palletops.cluster.hadoop.cli.version/version]
             :no-note  ["com.sun.jna.**"
                        "ch.qos.logback.**"
                        "com.jcraft.jsch.**"]
             :no-warn ["com.sun.jna.**"
                       "ch.qos.logback.**"
                       "com.jcraft.jsch.**"]
             :repackage-classes palletops
             :allow-access-modification true
             ;; :flatten-package-hierarchy palletops
             :keep-main true
             :keep-clojure true
             :verbose true
             :obfuscate true
             :shrink true
             :preverify true
             :keep-attributes [:EnclosingMethod]}} ; :InnerClasses

 :jclouds
 {:dependencies
  [[com.palletops/pallet-jclouds "1.5.3"]
   [org.jclouds.provider/aws-ec2 "1.5.5"]
   [org.jclouds.provider/aws-s3 "1.5.5"]
   [org.jclouds.driver/jclouds-slf4j "1.5.5"
    ;; the declared version is old and can overrule the resolved version
    :exclusions [org.slf4j/slf4j-api]]
   [org.jclouds.driver/jclouds-sshj "1.5.5"]]}
 :proguard {:plugins [[lein-proguard "0.1.0"]]}}
