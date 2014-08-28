;;; A simple cluster specification.

;;; The specification is a clojure map.

{:cluster-prefix "hc1"                ; all nodes will be named with this prefix

 ;; The node-spec here is used to specify hardware and os choices across all
 ;; types of nodes.
 :node-spec {:image                     ; used to specify image choices
             { ;; :image-id can be used to select a specific ami (recommended)
              :os-family :ubuntu
              :os-version-matches "12.04" ; this is a regex
              :os-64-bit true}}

 ;; For each type of node (a group) we want, we can specify its roles, the
 ;; hardware, etc., and the number of nodes of that type to run.  The node-spec
 ;; for a group is merged with the common node-spec.
 :groups
 {:master                                 ; group name
  {:node-spec {:hardware                  ; used to specify vm size choices
               {:hardware-id "m1.medium"}}; "m1.medium" is aws-specific
   :count 1                               ; how many nodes to run in this group
   :roles #{:namenode :jobtracker}}       ; hadoop roles to run on these nodes

  :slave
  {:node-spec {:hardware
               {:hardware-id "m1.medium"}}
   :count 2
   :roles #{:datanode :tasktracker}}}

 :hadoop-settings
 {:dist :cloudera
  ;; Use a mirror of cloudera's distribution for greater reliability and speed
  :cloudera-version "3.6"
  :version "0.20.2"
  :url "http://archive-primary.cloudera.com/cdh/3/hadoop-0.20.2-cdh3u6.tar.gz"
  ;;; By default, the ec2 credentials used to start the cluster will be used
  ;;; for s3 access. You can override the credentials here.
  ;; :fs.s3.awsAccessKeyId "your-key"
  ;; :fs.s3.awsSecretAccessKey "your-secret"
  ;; :fs.s3n.awsAccessKeyId "your-key"
  ;; :fs.s3n.awsSecretAccessKey "your-secret"
  }}
