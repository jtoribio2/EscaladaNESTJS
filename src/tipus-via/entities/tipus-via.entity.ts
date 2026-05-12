import { Column, Entity, OneToMany, PrimaryGeneratedColumn } from 'typeorm';
import { Via } from 'src/vias/entities/via.entity';

@Entity('tipus_via')
export class TipusVia {

  @PrimaryGeneratedColumn({ name: 'id_tipus_via' })
  idTipusVia!: number;

  @Column({
    name: 'tipus',
    type: 'varchar',
    length: 10,
    nullable: false
  })
  tipus!: string;

  @OneToMany(() => Via, (via) => via.tipusVia)
  vies!: Via[];

}