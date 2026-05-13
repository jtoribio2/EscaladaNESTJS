import { Injectable } from '@nestjs/common';

import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';

import { Escalador } from './entities/escalador.entity';

import { FilterEscaladorDto } from './dto/filter-escalador.dto';

@Injectable()
export class EscaladorsService {

  constructor(

    @InjectRepository(Escalador)
    private escaladorRepository: Repository<Escalador>,

  ) {}

  findAll(filters: FilterEscaladorDto) {

    const query = this.escaladorRepository
      .createQueryBuilder('escalador');

    if (filters.dni) {

      query.andWhere(
        'escalador.dni = :dni',
        {
          dni: filters.dni,
        },
      );
    }

    if (filters.nom) {

      query.andWhere(
        'escalador.nom = :nom',
        {
          nom: filters.nom,
        },
      );
    }

    if (filters.edat) {

      query.andWhere(
        'escalador.edat = :edat',
        {
          edat: filters.edat,
        },
      );
    }

    if (filters.estil) {

      query.andWhere(
        'escalador.estil = :estil',
        {
          estil: filters.estil,
        },
      );
    }

    return query.getMany();
  }

  findOne(id: number) {

    return this.escaladorRepository.findOne({

      where: {
        idEscalador: id,
      },

    });
  }
}