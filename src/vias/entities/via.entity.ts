import { Entity, PrimaryGeneratedColumn, Column } from 'typeorm';
import { ManyToOne, JoinColumn } from 'typeorm';
import { Sector } from '../../sectors/entities/sector.entity';
import { TipusVia } from '../../tipus-via/entities/tipus-via.entity';

@Entity('vies')
export class Via {

  @PrimaryGeneratedColumn()
  id_via!: number;

  @ManyToOne(() => Sector)
  @JoinColumn({ name: 'id_sector' })
  sector!: Sector;

  @ManyToOne(() => TipusVia, (tipusVia) => tipusVia.vies)
  @JoinColumn({ name: 'id_tipus_via' })
  tipusVia!: TipusVia;

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