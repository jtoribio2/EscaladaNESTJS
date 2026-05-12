import { Injectable } from '@nestjs/common';

import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';

import { Escola } from './entities/escola.entity';
import { FilterEscolaDto } from './dto/filter-escola.dto';

@Injectable()
export class EscolesService {

  constructor(

    @InjectRepository(Escola)
    private escolaRepository: Repository<Escola>,

  ) {}

  findAll(filters: FilterEscolaDto) {

  const query = this.escolaRepository
    .createQueryBuilder('escola');

  if (filters.nom) {

    query.andWhere(
      'escola.nom = :nom',
      {
        nom: filters.nom,
      },
    );
  }

  if (filters.lloc) {

    query.andWhere(
      'escola.lloc = :lloc',
      {
        lloc: filters.lloc,
      },
    );
  }

  if (filters.aproximacio) {

    query.andWhere(
      'escola.aproximacio = :aproximacio',
      {
        aproximacio: filters.aproximacio,
      },
    );
  }

  if (filters.popularitat) {

    query.andWhere(
      'escola.popularitat = :popularitat',
      {
        popularitat: filters.popularitat,
      },
    );
  }

  return query.getMany();
}

  findOne(id: number) {

    return this.escolaRepository.findOne({

      where: {
        idEscola: id,
      },

    });
  }
}