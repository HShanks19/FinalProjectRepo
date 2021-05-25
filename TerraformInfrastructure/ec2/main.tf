resource "aws_instance" "docker_instance" {
  ami               = var.ami_id 
  instance_type     = var.instance_type 
  availability_zone = var.av_zone 
  key_name          = var.key_name
  
  network_interface {
    device_index         = 0
    network_interface_id = var.net_id_prod
  }
  tags = {
    Name = "production"
  }
}
resource "aws_instance" "docker_instance_test" {
  ami               = var.ami_id 
  instance_type     = var.instance_type 
  availability_zone = var.av_zone 
  key_name          = var.key_name
  
  network_interface {
    device_index         = 0
    network_interface_id = var.net_id_test
  }
  tags = {
    Name = "development"
  }
}

resource "aws_instance" "jenkins" {
  ami               = var.ami_id 
  instance_type     = var.instance_type 
  availability_zone = var.av_zone 
  key_name          = var.key_name

  network_interface {
    device_index         = 0
    network_interface_id = var.net_id_jenk
  }

  tags = {
    Name = "jenkins"
  }
}

resource "aws_instance" "bastion" {
  ami               = var.ami_id 
  instance_type     = var.instance_type 
  availability_zone = var.av_zone 
  key_name          = var.key_name
  user_data = file("C:/Users/local_admin/Terraform/terraform/bastionsetup.sh")
  network_interface {
    device_index         = 0
    network_interface_id = var.net_id_bast
  }
  tags = {
    Name = "bastion"
  }

}

resource "aws_db_parameter_group" "default" {
  name   = "rds-pg"
  family = "mysql5.7"

  parameter {
    name  = "character_set_server"
    value = "utf8"
  }

  parameter {
    name  = "character_set_client"
    value = "utf8"
  }

  parameter {
    name  = "log_bin_trust_function_creators"
    value = "1"
  }

}

resource "aws_db_instance" "mysqldb" {
  identifier             = "mysqldb"
  name                   = "users"
  instance_class         = "db.t3.micro"
  allocated_storage      = 5
  engine                 = "mysql"
  engine_version         = "5.7"
  username               = "root"
  password               = var.db_password
  db_subnet_group_name   = var.subnet_group_name
  vpc_security_group_ids = [var.sec_group_id]
  parameter_group_name   = "default.mysql5.7"
  publicly_accessible    = false
  skip_final_snapshot    = true
}