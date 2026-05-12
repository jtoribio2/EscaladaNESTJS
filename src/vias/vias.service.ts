import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { CreateViaDto } from './dto/create-via.dto';

import { Via } from './entity/via.entity';

@Injectable()
export class ViasService {

    constructor(
        @InjectRepository(Via)
        private viaRepository: Repository<Via>,
    ) { }

    findAll() {
        return this.viaRepository.find();
    }

    create(createViaDto: CreateViaDto) {

        const via = this.viaRepository.create(createViaDto);

        return this.viaRepository.save(via);
    }
}