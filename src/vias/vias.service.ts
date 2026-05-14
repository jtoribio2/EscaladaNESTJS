import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';

import { CreateViaDto } from './dto/create-via.dto';
import { FilterViaDto } from './dto/filter-via.dto';

import { Via } from './entities/via.entity';

@Injectable()
export class ViasService {

    constructor(
        @InjectRepository(Via)
        private viaRepository: Repository<Via>,
    ) { }

    findAll(filters: FilterViaDto) {

        const query = this.viaRepository
            .createQueryBuilder('via')
            .leftJoinAndSelect('via.sector', 'sector')
            .leftJoinAndSelect('via.tipusVia', 'tipusVia');

        if (filters.dificultat) {

            query.andWhere(
                'via.dificultat = :dificultat',
                {
                    dificultat: filters.dificultat,
                },
            );
        }

        if (filters.orientacio) {

            query.andWhere(
                'via.orientacio = :orientacio',
                {
                    orientacio: filters.orientacio,
                },
            );
        }

        if (filters.ancoratge) {

            query.andWhere(
                'via.ancoratge = :ancoratge',
                {
                    ancoratge: filters.ancoratge,
                },
            );
        }

        if (filters.troca) {

            query.andWhere(
                'via.troca = :troca',
                {
                    troca: filters.troca,
                },
            );
        }

        if (filters.sector) {

            query.andWhere(
                'sector.id_sector = :sector',
                {
                    sector: filters.sector,
                },
            );
        }

        return query.getMany();
    }

    findOne(id: number) {

        return this.viaRepository.findOne({
            where: {
                id_via: id,
            },
            relations: ['sector', 'tipusVia'],
        });
    }

    create(createViaDto: CreateViaDto) {

        const via = this.viaRepository.create(createViaDto);

        return this.viaRepository.save(via);
    }
}