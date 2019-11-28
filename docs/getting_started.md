# SolrCloud Concepts


Logical Concepts
---------                              
- __Cluster__ - hosts multiple **Collections** 
- __Collection__ is partitioned into multiple __Shards__
- __Shard__ contains a subset of the Documents in the Collection.


Physical Concepts
---------
- __Cluster__ is made up of __Nodes__
- __Node__ hosts multiple __Cores__. Node is a running instance of Solr server process. 
- __Core__ is a physical __Replica__ for a logical __Shard__
