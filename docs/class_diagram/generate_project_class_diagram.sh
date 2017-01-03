#!/usr/bin/env bash

python3 generate_project_class_dot_graph.py
dot -Tpng pms_cd.gv -o pms_cd.png