import { Injectable, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Like, Repository } from 'typeorm';

import { TipusVia } from './entities/tipus-via.entity';
import { FilterTipusViaDto } from './dto/filter-tipus-via.dto';

@Injectable()
export class TipusViaService {

  constructor(
    @InjectRepository(TipusVia)
    private readonly tipusViaRepository: Repository<TipusVia>,
  ) {}



  async findAll(filterDto: FilterTipusViaDto): Promise<TipusVia[]> {

    const where: any = {};

    if (filterDto.tipus) {
      where.tipus = Like(`%${filterDto.tipus}%`);
    }

    return await this.tipusViaRepository.find({
      where,
    });
  }

  async findOne(id: number): Promise<TipusVia> {

    const tipusVia = await this.tipusViaRepository.findOne({
      where: { idTipusVia: id },
    });

    if (!tipusVia) {
      throw new NotFoundException(
        `No existeix el tipus de via amb id ${id}`,
      );
    }

    return tipusVia;
  }

  
}