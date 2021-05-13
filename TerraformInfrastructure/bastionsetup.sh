#! /bin/bash
sudo apt-get update
sudo apt install software-properties-common
sudo apt-add-repository --yes --update ppa:ansible/ansible
sudo apt install ansible -y
git clone https://github.com/HShanks19/FinalProjectRepo
sudo apt install mysql-client-core-8.0
sudo apt-get install mysql-server