import {
  Entity,
  PrimaryGeneratedColumn,
  Column,
} from 'typeorm';

@Entity('escaladors')
export class Escalador {

  @PrimaryGeneratedColumn({
    name: 'id_escalador',
  })
  idEscalador!: number;

  @Column({
    length: 9,
  })
  dni!: string;

  @Column()
  nom!: string;

  @Column()
  edat!: number;

  @Column()
  estil!: number;
}