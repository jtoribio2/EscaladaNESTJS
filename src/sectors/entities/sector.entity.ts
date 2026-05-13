import {
  Entity,
  PrimaryGeneratedColumn,
  Column,
  ManyToOne,
  JoinColumn,
} from 'typeorm';

import { Escola } from '../../escoles/entities/escola.entity';

@Entity('sectors')
export class Sector {

  @PrimaryGeneratedColumn({
    name: 'id_sector',
  })
  idSector!: number;

  @Column()
  nom!: string;

  @Column('decimal', {
    precision: 9,
    scale: 6,
  })
  latitut!: number;

  @Column('decimal', {
    precision: 5,
    scale: 2,
  })
  longitut!: number;

  @Column()
  aproximacio!: string;

  @Column()
  popularitat!: number;

  @ManyToOne(() => Escola)
  @JoinColumn({ name: 'id_escola' })
  escola!: Escola;
}