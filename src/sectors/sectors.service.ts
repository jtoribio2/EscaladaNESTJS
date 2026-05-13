import { Injectable } from '@nestjs/common';

import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';

import { Sector } from './entities/sector.entity';

import { FilterSectorDto } from './dto/filter-sector.dto';

@Injectable()
export class SectorsService {

  constructor(

    @InjectRepository(Sector)
    private sectorRepository: Repository<Sector>,

  ) {}

  findAll(filters: FilterSectorDto) {

    const query = this.sectorRepository
      .createQueryBuilder('sector')
      .leftJoinAndSelect(
        'sector.escola',
        'escola',
      );

    if (filters.nom) {

      query.andWhere(
        'sector.nom = :nom',
        {
          nom: filters.nom,
        },
      );
    }

    if (filters.aproximacio) {

      query.andWhere(
        'sector.aproximacio = :aproximacio',
        {
          aproximacio: filters.aproximacio,
        },
      );
    }

    if (filters.popularitat) {

      query.andWhere(
        'sector.popularitat = :popularitat',
        {
          popularitat: filters.popularitat,
        },
      );
    }

    if (filters.escola) {

      query.andWhere(
        'escola.idEscola = :escola',
        {
          escola: filters.escola,
        },
      );
    }

    return query.getMany();
  }

  findOne(id: number) {

    return this.sectorRepository.findOne({

      where: {
        idSector: id,
      },

      relations: ['escola'],
    });
  }
}