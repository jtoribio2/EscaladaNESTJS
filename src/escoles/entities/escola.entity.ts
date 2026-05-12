import {
  Entity,
  PrimaryGeneratedColumn,
  Column,
} from 'typeorm';

@Entity('escoles')
export class Escola {

  @PrimaryGeneratedColumn({
    name: 'id_escola',
  })
  idEscola!: number;

  @Column()
  nom!: string;

  @Column()
  lloc!: string;

  @Column()
  aproximacio!: string;

  @Column()
  popularitat!: number;
}