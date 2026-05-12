import { Entity, PrimaryGeneratedColumn, Column } from 'typeorm';

@Entity('vies')
export class Via {

  @PrimaryGeneratedColumn()
  id_via!: number;

  @Column()
  nom!: string;

  @Column()
  llargada!: number;

  @Column()
  dificultat!: string;

  @Column()
  orientacio!: string;

  @Column()
  ancoratge!: string;

  @Column()
  troca!: string;
}